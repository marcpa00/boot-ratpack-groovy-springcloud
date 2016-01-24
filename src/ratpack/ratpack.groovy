import com.example.SpringBootConfig
import com.example.MyHandler
import ratpack.spring.Spring

import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
      bindInstance(new MyHandler())
  }
  handlers {
    register(Spring.spring(SpringBootConfig))
    get {
      render "Hello World from ratpack + boot + eureka (client)"
    }
    
    post('echo-input', registry.get(MyHandler))
  }
}
