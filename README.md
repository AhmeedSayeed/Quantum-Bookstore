# Quantum Bookstore

An online bookstore application designed to manage different types of books:

- **PaperBook**: Has stock and can be shipped
- **EBook**: Has a filetype and can be sent via email
- **Showcase/DemoBook**: Not for sale

All print statements in this project are prefixed with **Quantum book store**.

---

## 📌 Features

✅ Add books to inventory  
✅ Remove and return outdated books  
✅ Buy books (check stock, reduce stock, return paid amount, "deliver" by message)  
✅ Easily extensible design for adding new product types  

---

## 📦 Classes

- `Book` *(abstract)*: base class with ISBN, title, author, price, year  
- `PaperBook`, `EBook`, `DemoBook`: specific types with their own behavior  
- `Inventory`: manages adding, removing, buying books
- `PurchaseResult`: encapsulates payment and delivery message
- `QuantumBookstoreFullTest`: runs example scenarios

---

