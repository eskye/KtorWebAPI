import io.ktor.server.netty.*
import io.ktor.application.*
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer

fun main(args:Array<String>){
    embeddedServer(Netty,8080){
        routing {
            get("/"){
                call.respondText("Hello, World", ContentType.Text.Html)
            }
        }

        routing {
            get("/home"){
                call.respondText("I am now home", ContentType.Text.Html)
            }
        }
    }.start(wait = true)

}
