package ch.martinelli.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class IndexResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
                .when().get("/")
                .then()
                .statusCode(200)
                .body(is("""
                        +----+----------+---------+
                        |  id|first_name|last_name|
                        +----+----------+---------+
                        |   1|John      |Doe      |
                        +----+----------+---------+
                        """));
    }

}