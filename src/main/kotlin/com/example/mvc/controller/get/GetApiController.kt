package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController // REST API Controller 동작
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {
    @GetMapping("/hello") // GET http://localhost:8080/api/hello
    fun hello():String{

        return "hello Kotlin"

    }

    @RequestMapping(method = [RequestMethod.GET],path=["/request-mapping"])
    fun requestMapping():String{
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable(@PathVariable name:String,@PathVariable age:Int):String{
        println("${name} ${age}" )

        return name + " " + age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable2(@PathVariable(value = "name") _name:String, @PathVariable(name = "age") age:Int):String{
        val name = "kotlin"
        println("${_name} ${age}" )

        return _name + " " + age
    }

    //query parameter
    // http://localhost:8080/api/page?key=value&key=value&key=value
    @GetMapping("/get-mapping/query-param")// ?name=steve&age=20
    fun qeuryParameter(@RequestParam(name="name") name: String,
                       @RequestParam(value = "age") age:Int
    ):String{
        println("${name}, ${age}")

        return name+ " " +age

    }

    @GetMapping("/get-mapping/query-param/object")
    fun queryPramObject(userRequest: UserRequest):UserRequest{
        println("hello!!!!!!!")
        println("hello")
        println("hello")
        println(userRequest)

        println("hello!!!!!!!")
        return userRequest

    }

    @GetMapping("get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map:Map<String,Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map.get("phone-number")
        return map

    }


}