import com.example.DemoApplication
import com.example.MyHandler
import ratpack.spring.Spring

import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
      bindInstance(new MyHandler())
  }
  handlers {
    register(Spring.spring(DemoApplication))
    get {
      render "Hello World from ratpack"
    }
    
    post('echo-input', registry.get(MyHandler))
  }
}
