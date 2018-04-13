package com.simply.zuozuo;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.simply.zuozuo.controller.compent.RestfulController;
import com.simply.zuozuo.controller.compent.UserController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * 自动模拟MVC的http请求
 *
 * @WebMvcTest(UserController.class) 通过该方式可以只实例化一个控制器
 */
@AutoConfigureMockMvc
@ConfigurationProperties(prefix = "")
public class ZuozuoApplicationTests {


    @Autowired
    private UserController userController;


    /**
     * 注入mockmvc的模拟器
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * 使用 @MockBean 注入一个组件
     */
    @MockBean
    private RestfulController restfulController;

    /**
     * 自动注入服务的端口
     */
    @LocalServerPort
    private String port;

    private String ctx;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {

        // 断言userController不为空
        Assertions.assertThat(userController).isNotNull();


        // 断言控制器一定返回2
        Assertions.assertThat("2".equals(restTemplate.getForObject(ctx + "", String.class)));

        // mvc
        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));

    }

}
