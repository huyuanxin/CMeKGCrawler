package yuanxin.knowledge.crawler.util;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author huyuanxin
 */
public class SaveFileUtil {

    public static boolean saveFile(String type) {
        boolean result = false;
        List<String> nameList = CrawlerUtil.getNameList(type);
        for (String name : nameList
        ) {
            name = name.replace("\n", "").replace("\\", "").replace("/", "");
            JSONObject diseaseJson = CrawlerUtil.getJson(name, type);
            List<String> categoriesList = CrawlerUtil.getCategoriesList(diseaseJson);
            int size = categoriesList.size();
            HashMap<String, Object> map = new HashMap<>(size);
            for (int i = 2; i < size; ++i) {
                List<String> diseaseInfo = CrawlerUtil.getInfo(diseaseJson, i);
                map.put(categoriesList.get(i), diseaseInfo);
            }
            JSONObject json = new JSONObject(map);
            result = createJsonFile(json, type, name);
            System.out.println(name);
        }
        return result;
    }

    public static boolean saveAll(String type) {
        List<JSONObject> allJsonList = new ArrayList<>();
        List<String> nameList = CrawlerUtil.getNameList(type);
        for (String name : nameList
        ) {
            name = name.replace("\n", "").replace("\\", "").replace("/", "");
            JSONObject diseaseJson = CrawlerUtil.getJson(name, type);
            List<String> categoriesList = CrawlerUtil.getCategoriesList(diseaseJson);
            int size = categoriesList.size();
            HashMap<String, Object> map = new HashMap<>(size + 1);
            map.put("名称", name);
            for (int i = 2; i < size; ++i) {
                List<String> diseaseInfo = CrawlerUtil.getInfo(diseaseJson, i);
                map.put(categoriesList.get(i), diseaseInfo);
            }
            JSONObject json = new JSONObject(map);
            allJsonList.add(json);
            System.out.println(name);
        }
        HashMap<String, Object> jsonMap = new HashMap<>(2);
        jsonMap.put("size", nameList.size());
        jsonMap.put(type, allJsonList);
        JSONObject json = new JSONObject(jsonMap);
        return createJsonFile(json, type, type);
    }


    public static boolean createJsonFile(JSONObject json, String type, String fileName) {
        String content = JSONObject.toJSONString(json);
        boolean flag = true;
        try {
            File file = new File("src\\main\\json\\" + type + "\\" + fileName + ".json");
            if (!file.getParentFile().exists()) {
                flag = file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                flag = file.delete();
            }
            flag = file.createNewFile();
            // 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            write.write(content);
            write.flush();
            write.close();
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
    }
}
