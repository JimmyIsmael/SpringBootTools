# Internationalization with Spring Boot #
This is an example of how to implement the i18n using Spring Boot.

## What do you need. 
in order to use the i18n in your own project you will need to add the following dependencies to yor POM file:

### Thymeleaf Dependency
Thymeleaf is an template engine that allows you to manipulate your HTML files in an incredible way.

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
## Configuration Class
Spring has its own way to deal with the internationalization part, for us to be able to work with it, we need to implement the following methods on a configuration class.

```
@Bean
public ReloadableResourceBundleMessageSource messageSource(){
    ReloadableResourceBundleMessageSource resourceBundleMessageSource=new ReloadableResourceBundleMessageSource();
    resourceBundleMessageSource.setBasename("classpath:i18n/messages");

    //checks for new messages every 30 minutes
    resourceBundleMessageSource.setCacheSeconds(1800);
    return resourceBundleMessageSource;
}

@Bean
public LocaleResolver localeResolver(){
    SessionLocaleResolver r = new SessionLocaleResolver();
    r.setDefaultLocale(Locale.US);
    return r;
}
```

## Messages Files
Since in one of the previous methods we have told to Spring that the messages will be in a folder called i18n/messages, we need to create that under the resources folder, and inside that folder create our messages files. 

Keep in mind that the files need to have the followin naming convention: messages_localeCode.properties.
  
What this means is that if we want a messages file for Dominican Spanish it needs to be named as: messages_es_DO.properties. 

So we can declare that locale and call the file as we are going to show later.

#### messages_en_DO.properties
The spanish messages file should have a key and a value for every message, sush as:
```
page.banner=Hola Mundo!
```
Where page.banner is the key that we are going to call in the HTML.

#### messages_es_US.properties
The english messages file should have a key and a value for every message, sush as:
```
page.banner=Hello World!
```
Where page.banner is the key that we are going to call in the HTML.

## Controller
In our controller, we need to @Autowired the LocaleResolver method and declare different locales or load them from a database. In this case we are declaring the locales in the controller.  

```
@Controller
public class WebController {
    @Autowired
    LocaleResolver localeResolver;

    Locale espanol = new Locale("es_DO");
    Locale ingles = new Locale("en_US" );

    @RequestMapping("/es")
    public String indexPageES(Model model, HttpServletRequest request){
        localeResolver.setLocale(request,null,espanol);
        return "index";
    }

    @RequestMapping("/en")
    public String indexPageEN(Model model, HttpServletRequest request){
        localeResolver.setLocale(request,null,ingles);
        return "index";
    }
}
```

## HTML File
Finally, we just need to tell our HTML how to call those messages using the thymeleaf th:text, like this:

```
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
</head>
<body>
    <h1 th:text="#{page.banner}"></h1>
</body>
</html>
```
