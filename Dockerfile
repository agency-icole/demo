FROM agencyicole/runtime:1.2.0

COPY target/classes /app
COPY target/lib /app/lib

HEALTHCHECK --interval=5s --timeout=3s CMD wget -qO-  --content-on-error=on http://localhost:8080/docker/health
CMD java -cp .:lib/* com.example.demo.DemoApplication

