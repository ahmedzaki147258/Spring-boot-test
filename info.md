> **ℹ️ Info:**  
> In Thymeleaf,  
> ```html
> <td th:text="${staff.name}">Name</td>
> ```  
> uses a **variable expression** (`${...}`) to display the value of `staff.name` in the table cell.
>  
> --- 
On the other hand,  
> ```html
> <td th:text="*{name}">Name</td>
> ```  
> uses a **selection expression** (`*{...}`) to display the value of `staff.name` in the table cell.
