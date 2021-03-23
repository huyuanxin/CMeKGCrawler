package yuanxin.knowledge.crawler.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.*;

/**
 * @author huyuanxin
 */
public class CrawlerUtil {

    /**
     * 爬取疾病名称
     *
     * @return 疾病名称
     */
    public static List<String> getNameList(String name) {
        int id = 0;
        if ("疾病".equals(name)) {
            id = 117;
        } else if ("药物".equals(name)) {
            id = 96;
        } else if ("症状".equals(name)) {
            id = 29;
        } else if ("诊疗".equals(name)) {
            id = 29;
        }
        List<String> nameList = new ArrayList<>();
        String url = "https://zstp.pcl.ac.cn:8002/load_tree/" + name;
        String response = HttpUtil.get(url);
        JSONObject json = JSONObject.parseObject(response);
        JSONArray nodes = json.getJSONArray("nodes");
        for (Object obj : nodes
        ) {
            JSONObject temp = (JSONObject) obj;
            if (temp.getInteger("id") > id) {
                String diseaseName = temp.getString("name");
                nameList.add(diseaseName);
            }
        }
        return delRepeat(nameList);
    }

    /**
     * 获得疾病对应的Json
     *
     * @param name 名称
     * @param type 类型
     * @return 名称对应的Json
     */
    public static JSONObject getJson(String name, String type) {
        String url = String.format("https://zstp.pcl.ac.cn:8002/knowledge?name=%s&tree_type=%s", name, type);
        String response = HttpUtil.get(url);
        return JSONObject.parseObject(response);
    }

    /**
     * 获得疾病对应信息的JsonArray
     *
     * @param name 名称
     * @return 名称对应信息的JsonArray
     */
    public static JSONArray getNodesArray(String name, String type) {
        JSONObject json = getJson(name, type);
        if (json != null) {
            return json.getJSONArray("node");
        }
        return null;
    }

    /**
     * 获得疾病对应信息的JsonArray
     *
     * @param json 通过 {@link #getJson(String, String)}} 获得的json
     * @return 疾病对应信息的JsonArray
     */
    public static JSONArray getNodesArray(JSONObject json) {
        if (json != null) {
            return json.getJSONArray("node");
        }
        return null;
    }

    /**
     * 获得疾病对应标签的JsonArray
     *
     * @param name 名称
     * @param type 类型
     * @return 名称对应标签的JsonArray
     */
    public static JSONArray getCategoriesArray(String name, String type) {
        JSONObject json = getJson(name, type);
        if (json != null) {
            return json.getJSONArray("categories");
        }
        return null;
    }

    /**
     * 获得疾病对应标签的JsonArray
     *
     * @param json 通过 {@link #getJson(String, String)}} 获得的json
     * @return 疾病对应标签的JsonArray
     */
    public static JSONArray getCategoriesArray(JSONObject json) {
        if (json != null) {
            return json.getJSONArray("categories");
        }
        return null;
    }

    /**
     * 获取categoriesIndex对应的label内容
     *
     * @param json            通过 getDiseaseJson(String) 获得的json
     * @param categoriesIndex categories的id
     * @return categoriesIndex对应的label内容
     */
    public static List<String> getInfo(JSONObject json, int categoriesIndex) {
        return getInfo(getNodesArray(json), categoriesIndex);
    }

    /**
     * @param diseaseNodesArray 通过 {@link #getNodesArray(JSONObject)} 或者 {@link #getNodesArray(String, String)} 获得的json
     * @param categoriesIndex   categories的id
     * @return categoriesIndex对应的label内容
     */
    private static List<String> getInfo(JSONArray diseaseNodesArray, int categoriesIndex) {
        List<String> info = new ArrayList<>();
        if (diseaseNodesArray != null) {
            for (Object obj : diseaseNodesArray
            ) {
                JSONObject temp = (JSONObject) obj;
                if (temp.getInteger("category") == categoriesIndex) {
                    String label = temp.getString("label");
                    if (label != null) {
                        info.add(label);
                    }
                }
            }
        }
        return info;
    }

    /**
     * 获取categoriesIndex对应的label内容
     *
     * @param name            名称
     * @param type            类型
     * @param categoriesIndex categories的id
     * @return categoriesIndex对应的label内容
     */
    public static List<String> getInfo(String name, String type, int categoriesIndex) {
        return getInfo(getNodesArray(name, type), categoriesIndex);
    }

    /**
     * 获得属性名称
     *
     * @param json  通过 {@link #getJson(String, String) }获得的json
     * @param index 排列位置的序号
     * @return 属性名称
     */
    public static String getCategoriesNameByIndex(JSONObject json, int index) {
        return getCategoriesNameByIndex(getCategoriesArray(json), index);
    }

    /**
     * 获得属性名称
     *
     * @param name  疾病名称
     * @param type  类型
     * @param index 排列位置的序号
     * @return 属性名称
     */
    public static String getCategoriesNameByIndex(String name, String type, int index) {
        return getCategoriesNameByIndex(getCategoriesArray(name, type), index);
    }

    /**
     * 获得属性名称
     *
     * @param categoriesArray 通过 {@link #getCategoriesArray(JSONObject)} 或者 {@link #getCategoriesArray(String, String)}获得的JsonArray
     * @param index           排列位置的序号
     * @return 属性名称
     */
    private static String getCategoriesNameByIndex(JSONArray categoriesArray, int index) {
        if (categoriesArray != null) {
            JSONObject categoriesNameArray = categoriesArray.getJSONObject(index);
            if (categoriesNameArray != null) {
                String categoriesName = categoriesNameArray.getString("name");
                if (categoriesName != null) {
                    return categoriesName;
                }
            }
        }
        return "";
    }

    /**
     * 提取categoriesArray的内容
     *
     * @param categoriesArray 通过 {@link #getCategoriesArray(JSONObject)} 或者 {@link #getCategoriesArray(String, String)}获得的JsonArray
     * @return categoriesArray的内容
     */
    public static List<String> getCategoriesList(JSONArray categoriesArray) {
        List<String> categoriesList = new ArrayList<>();
        for (Object obj : categoriesArray) {
            JSONObject temp = (JSONObject) obj;
            String name = temp.getString("name");
            categoriesList.add(name);
        }
        return categoriesList;
    }

    /**
     * 提取categoriesArray的内容
     *
     * @param json 通过 {@link #getJson(String, String)}} 获得的json
     * @return categoriesArray的内容
     */
    public static List<String> getCategoriesList(JSONObject json) {
        if (json != null) {
            return getCategoriesList(getCategoriesArray(json));
        }
        return new ArrayList<>();

    }


    public static List<String> delRepeat(List<String> list) {
        return new ArrayList<>(new TreeSet<>(list));
    }


    public static List<String> getDiseaseJsonComponent(String type, String key) {
        String file = "src\\main\\json\\" + type + "\\" + type + ".json";
        List<String> result = new ArrayList<>();
        JSONObject json = readJsonFile(file);
        assert json != null;
        JSONArray array = json.getJSONArray(type);
        for (Object o : array
        ) {
            JSONObject temp = (JSONObject) o;
            JSONArray tempArray = temp.getJSONArray(key);
            if (tempArray != null) {
                for (Object s : tempArray) {
                    String str = (String) s;
                    if (!str.contains("%") && !str.contains(".")) {
                        result.add(str);
                    }
                }
            }
        }
        return delRepeat(result);
    }

    public static JSONObject readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return JSONObject.parseObject(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param type 类型
     * @param key  属性
     * @return <"药名",List<"属性列">>
     */
    public HashMap<String, List<String>> getDiseaseJsonComponentToHashMap(String type, String key) {
        String file = "src\\main\\json\\" + type + "\\" + type + ".json";
        HashMap<String, List<String>> result = new HashMap<>();
        JSONObject json = readJsonFile(file);
        assert json != null;
        JSONArray array = json.getJSONArray(type);
        for (Object o : array
        ) {
            List<String> list = new ArrayList<>();
            JSONObject temp = (JSONObject) o;
            JSONArray tempArray = temp.getJSONArray(key);
            if (tempArray != null) {
                for (Object s : tempArray) {
                    String str = (String) s;
                    list.add(str);
                }
                result.put(temp.getString("名称"), list);
            }
        }
        return result;
    }
}
