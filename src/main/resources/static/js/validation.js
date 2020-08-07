function validateBook() {
    var formValid = true;

    //FIELDS
    var isbn = document.getElementById("isbn").value;
    var author = document.getElementById("author").value;
    var quantity = document.getElementById("quantity").value;
    var year = document.getElementById("year").value;

    //ERRORS
    var isbnError = document.getElementById("isbn-error");
    var authorError = document.getElementById("author-error");
    var quantityError = document.getElementById("quantity-error");
    var yearError = document.getElementById("year-error");

    //RESET
    var errorMessages = document.getElementsByTagName("span");
    for (let i = 0; i < errorMessages.length; i++) {
        errorMessages[i].innerHTML = "";
    }


    if (!isbn || isbn.match(/[a-z-A-Z]/) || isbn.length > 15) { //2 character allowance for dashes
        isbnError.innerHTML = "Please provide a 10 or 13 digit ISBN number"
        formValid = false;
    }

    if(!author){
        authorError.innerHTML = "Please provide an author"
        formValid = false;
    }

    if(!quantity || quantity < 0){
        quantityError.innerHTML = "Please provide a valid quantity"
        formValid = false;
    }

    if(!year || year > 2021){
        yearError.innerHTML = "Please provide a valid year"
        formValid = false
    }

    return formValid;
}

function validateCategory(){
    var formValid = true;

    var categoryName = document.getElementById("category-name").value;

    var categoryError = document.getElementById("category-error");

    if (!categoryName) {
        categoryError.innerHTML = "Please provide a category name";
        formValid = false;
    }

    return formValid;
}