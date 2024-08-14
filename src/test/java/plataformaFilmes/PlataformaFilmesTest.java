package plataformaFilmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import maps.LoginMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlataformaFilmesTest {

    @Test
    public void deveValidarLogin() {
        RestAssured.baseURI = "http://localhost:8080/";

        String json = "{" +
                "    \"email\": \"aluno@email.com\"," +
                "    \"senha\": \"123456\"" +
                "}";

        Response response = RestUtils.post(json, ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        LoginMap.token = response.jsonPath().get("token");
    }

    @BeforeAll
    public static void deveValidarLoginMap() {
        RestUtils.setBaseURI("http://localhost:8080/");

        LoginMap.initLogin();

        Response response = RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        LoginMap.token = response.jsonPath().get("token");
    }

    @Test
    public void deveValidarConsultaCategorias() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + LoginMap.token);

        Response response = RestUtils.get(header, "categorias");
        assertEquals(200, response.statusCode());

        System.out.println(response.jsonPath().get().toString());

        List<String> listTipo = new ArrayList<>();
        listTipo.add("Aventura");
        listTipo.add("Acao");
        listTipo.add("Terror");
        listTipo.add("Drama");
        listTipo.add("Comedia");
        listTipo.add("Sobrevivencia");
        listTipo.add("Crime");
        listTipo.add("Thriller");

        assertEquals(listTipo, response.jsonPath().get("tipo"));

    }


}
