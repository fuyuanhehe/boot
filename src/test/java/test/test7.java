package test;


import com.boot.boot.service.testService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
//@TestPropertySource("classpath:application.yml")

*/
@Slf4j
public class test7 {


    @Resource
    testService testServicebb;

    public static void main(String[] args) {

     //   double a = Math.ceil(0.11);

    //    System.out.print();

    }


    //  @Test
    public void tes77() {
        testServicebb.gg();


    }


}
