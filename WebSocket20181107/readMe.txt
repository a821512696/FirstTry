1.oracle的包得自己下载然后放到maven载入的路径下


2.使用ObjectMapper 需要的3个Package

  <!-- jackson 2.x （主要是用 ObjectMapper） 需要导入下面三个包 -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.9.7</version>
            <type>bundle</type>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.9.7</version>
            <type>bundle</type>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.7</version>
            <type>bundle</type>
        </dependency>

3. json 转List<ft> 时 应当构建javatype
 JavaType jt = ob.getTypeFactory().constructParametricType(List.class,ft.class);

 List<ft>   lfs = (List<ft>) ob.readValue(json,jt);

 类 转 json: String json = ob.writeValueAsString(lf);

 json 转类：  ft fttt =ob.readValue(json,ft.class);


 4.jquery 里 将json字符串 转为对象
 var datas = $.parseJSON(evt.data);

