function checkCart()  {
    var cart = localStorage.getItem("cart");

    if (cart == null)   {
        var cart = new Array();
        let json = JSON.stringify(cart);
        localStorage.setItem("cart", json);
    }
}

function addToCart() {
    var isAdd = false;
    checkCart();
    var cartJSON = localStorage.getItem("cart");
    var cart = JSON.parse(cartJSON);

    var id = document.getElementById("ID").innerText;
    var soLuong = document.getElementById("quantityInput").value;
    if(soLuong > 10) {
        soLuong = 10;
    }

    for(i = 0; i < cart.length; i++) {
        if(cart[i].ID == id)  {
            var book = cart[cart.length-1];
            book.SoLuong = Number(book.SoLuong) + Number(soLuong); 
            console.log(book.SoLuong);
            if(book.SoLuong >= 10) {
                book.SoLuong = 10;
                alert("Số lượng tối đa đối với khách hàng cá nhân là 10");
            }
            cart[cart.length-1] = book;
            isAdd = true;
            break;
        } else{
            continue;
        }

    }

    if(!isAdd) {
        var ten = document.getElementById("Ten").innerText;
        var hinh = document.getElementById("Hinh").getAttribute("src");
        var gia = document.getElementById("Gia").innerText;
        
        var book = {
            "ID": id,
            "Ten": ten,
            "Hinh": hinh,
            "Gia": gia,
            "SoLuong": soLuong,
        }
    
        cart[cart.length] = book;
    }
    
    let json = JSON.stringify(cart);
    localStorage.setItem("cart", json);
}

document.addEventListener("DOMContentLoaded", () => {
    var quantityInputs = document.getElementsByClassName('product-info-quantity-input');

    for (var i = 0; i < quantityInputs.length; i++) {
        quantityInputs[i].addEventListener('input', function () {
            var input = parseInt(this.value, 10);
            console.log(input);
            if (input >= 1 && input <= 10) {
                this.value = input;
            } else if (input <= 0 || isNaN(input)) {
                this.value = 1;
            } else if (input >= 10) {
                this.value = 10;
            }
        });
    }
});