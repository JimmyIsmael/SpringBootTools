# Pagination with SpringBoot and PageDialect

This example will show you how to have a pagination setion on your project using PageDialect and SpringDataJPA.

## To run this project, keep in mind that:

1) You need this dependency:

```
<!--Pagination Management-->
<dependency>
  <groupId>net.sourceforge.pagesdialect</groupId>
  <artifactId>pagesdialect-core</artifactId>
  <version>2.0.0</version>
</dependency>
```

2) Your repositories need to be like that:

```
  @Query("your custom query")
  Page<Roster> listAll(Pageable pageable);
```
3) Your services should be like:

```
  Page<Roster> listAll(Pageable pageable);
```

4) Your Impl methods should be like this:

```
  public Page<Roster> listAll(Pageable pageable){
      return salesRosterRepository.listAll(pageable);
  }
```

5) And finally your controllers need to have this structure:

```
@RequestMapping("/")
  public String loadData(Model model,
                         @RequestParam(defaultValue="1", value="page.page", required=false) Integer start,
                         @RequestParam(defaultValue="20", value="page.size", required=false) Integer size) {

      PageWrapper<Roster> page = new PageWrapper<Roster>(
              rosterFileService.listAll(new PageRequest(start-1, size, Sort.Direction.ASC, "ZRT")), "/");
      model.addAttribute("page",page);

      //"ZRT" is the field what it sorts by.
      //"/" is the view that calls the method.

      return "roster/index";
  }
```

And just add this code to your view.

```
<!-- Pagination Bar -->
  <div th:fragment="paginationbar">
      <div class="pagination pagination-centered">
          <ul class="pagination">
              <li th:class="${page.firstPage}? 'disabled' : '' ">
                  <span th:if="${page.firstPage}">← First</span>
                  <a th:if="${not page.firstPage}" th:href="@{${page.url}(page.page=1,page.size=${page.size})}">← First</a>
              </li>
              <li th:class="${page.hasPreviousPage}? '' : 'disabled'">
                  <span th:if="${not page.hasPreviousPage}">«</span>
                  <a th:if="${page.hasPreviousPage}" th:href="@{${page.url}(page.page=${page.number-1},page.size=${page.size})}" title="Go to previous page">«</a>
              </li>
              <li th:each="item : ${page.items}" th:class="${item.current}? 'active' : ''">
                  <span th:if="${item.current}" th:text="${item.number}">1</span>
                  <a th:if="${not item.current}" th:href="@{${page.url}(page.page=${item.number},page.size=${page.size})}"><span th:text="${item.number}">1</span></a>
              </li>
              <li th:class="${page.hasNextPage}? '' : 'disabled'">
                  <span th:if="${not page.hasNextPage}">»</span>
                  <a th:if="${page.hasNextPage}" th:href="@{${page.url}(page.page=${page.number+1},page.size=${page.size})}" title="Go to next page">»</a>
              </li>
              <li th:class="${page.lastPage}? 'disabled' : ''">
                  <span th:if="${page.lastPage}">Last →</span>
                  <a th:if="${not page.lastPage}" th:href="@{${page.url}(page.page=${page.totalPages},page.size=${page.size})}">Last →</a>
              </li>
          </ul>
      </div>
  </div>
```

Enjoy it!
