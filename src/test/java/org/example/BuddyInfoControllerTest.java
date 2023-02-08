package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BuddyInfoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //should look like this
    //{
    //    "id": "1",
    //    "name": "Haman",
    //    "phoneNum": "613-888-9999"
    //}
    //check for code 200, which mean the request is accepted
    @Test
    public void getBuddy() throws Exception {
        this.mockMvc.perform(put("/addressBook")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\"")));
        this.mockMvc.perform(post("/buddyInfoes?bookId=1").contentType(MediaType.APPLICATION_JSON).content
                (
                        "{\n" +
                        "\t\"id\":\"3\",\n" +
                        "\t\"name\":\"Char\",\n" +
                        "\t\"phoneNum\":\"6139999999\"\n" +
                        "}"
                )
        ).andDo(print()).andExpect(status().isCreated());
        this.mockMvc.perform(get("/buddyInfoes?bookId=1&buddyId=3")).andDo(print()).andExpect(status().isOk());
//                .andExpect(content().string(containsString("\"name\":\"Char\"")));
    }


    //should look like this
    //{
    //    "id": "1",
    //    "name": "Haman",
    //    "phoneNum": "613-888-9999",
    //}
    //check for code 404, which mean the page for Char is deleted and no longer can be found
    @Test
    public void removeBuddy() throws Exception {
        this.mockMvc.perform(put("/addressBook")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\"")));
        this.mockMvc.perform(post("/buddyInfoes?bookId=1").contentType(MediaType.APPLICATION_JSON).content(
                    "{\n" +
                        "\t\"id\":\"3\",\n" +
                        "\t\"name\":\"Char\",\n" +
                        "\t\"phoneNum\":\"6139999999\"\n" +
                    "}"
        )).andDo(print()).andExpect(status().isCreated());
        this.mockMvc.perform(delete("/buddyInfoes?bookId=1&buddyId=1")).andDo(print()).andExpect(status().isNotFound());
    }


    //should look like this
    //{
    //    "id": "1",
    //    "name": "Haman",
    //    "phoneNum": "613-888-9999"
    //}
    //check for code 201, which mean the request is successful = buddy char si created in the address book
    @Test
    public void addBuddy() throws Exception {
        this.mockMvc.perform(put("/addressBook")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\"")));
        this.mockMvc.perform(post("/buddyInfoes?bookId=1").contentType(MediaType.APPLICATION_JSON).content(
                "{\n" +
                "\t\"id\":\"3\",\n" +
                "\t\"name\":\"Char\",\n" +
                "\t\"phoneNum\":\"6139999999\"\n" +
                "}"
        )).andDo(print()).andExpect(status().isCreated());
    }
}