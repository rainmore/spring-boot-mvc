package au.com.rainmore.rest.controllers.demo

import au.com.rainmore.rest.controllers.BaseRestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

object RestController {

    private final val HelloWorldUri = "/rest/1/demo/hello-world"

}

@org.springframework.web.bind.annotation.RestController("demo.HelloWorldRestController")
class RestController extends BaseRestController {

    import RestController._

    @GetMapping(Array(HelloWorldUri))
    def helloWorld: ResponseEntity[String] = {
        ResponseEntity.ok("Hello world!")
    }
}
