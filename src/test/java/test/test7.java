package test;


import com.boot.boot.service.testService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
//@TestPropertySource("classpath:application.yml")

*/
@Slf4j
public class test7 {


    @Resource(name = "testServicebb")
    testService testServicebb;

    public static void main(String[] args) throws Exception {

        List<Integer> list = Arrays.asList(1,2,3);

        List<Integer> list2 = Arrays.asList(1,2,3,4);

        List<Integer> del = new ArrayList();

        for (Integer o : list2) {

            if(!list.contains(o)){
                del.add(o);
            }


        }

        System.out.print(del);



    }


    //  @Test
    public void tes77() {
        testServicebb.gg();


    }


}
