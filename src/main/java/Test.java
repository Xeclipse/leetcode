import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ximalaya.search.neural.general.CrfSeqModel;

import java.util.List;
import java.util.Map;

/**
 * @Author: Alex.Z
 * @DATE: 2017/10/27
 * @Description:
 */
public class Test {
    public void helloWorld(){
        System.out.println("Hello World");
    }


    @org.junit.Test
    public void testCRF(){
        CrfSeqModel sm = new CrfSeqModel();
        Map<String, String> filepaths = Maps.newHashMap();
        filepaths.put("vocab","/Users/nali/Eclipse_Workspace/search-xnlp/search-neural/Data/online_model_1568125921/word2id.txt");
        filepaths.put("label","/Users/nali/Eclipse_Workspace/search-xnlp/search-neural/Data/online_model_1568125921/label2id.txt");
        filepaths.put("model","/Users/nali/Eclipse_Workspace/search-xnlp/search-neural/Data/online_model_1568125921/model.pb");
        filepaths.put("node","/Users/nali/Eclipse_Workspace/search-xnlp/search-neural/Data/online_model_1568125921/nodeinfo");
        sm.loadModel(filepaths,null);
        String testCase = "you raise me up";
        List<String> caze = Lists.newArrayList();
        List<Character> chs = Lists.charactersOf(testCase);
        StringBuilder sb = new StringBuilder(1);
        for(Character c : chs){
            sb.append(c);
            caze.add(sb.toString());
            sb=new StringBuilder(1);
        }
        List<String> ans = sm.predict(caze);
        for(String label : ans){
            System.out.print(label+' ');
        }
    }

}
