var isMenuOpen = false;

const toggleSidebar = () => {
    var sidebar = document.getElementById('sidebar');
    var content = document.querySelector('.content');

    var computedStyle = window.getComputedStyle(sidebar);
    var sidebarLeft = computedStyle.getPropertyValue('left');

    if (sidebarLeft === '-250px') {
        sidebar.style.left = '0';
        content.style.marginLeft = '250px';
    } else {
        sidebar.style.left = '-250px';
        content.style.marginLeft = '0';
    }
}

const closeSidebar = () => {
    var sidebar = document.getElementById('sidebar');
    var content = document.querySelector('.content');

    sidebar.style.left = '-250px';
    content.style.marginLeft = '0';
}

const setActiveLink = (link) => {
    var sidebarLinks = document.querySelectorAll('.sidebar-link');
    sidebarLinks.forEach(function (sidebarLink) {
        sidebarLink.classList.remove('active');
    });

    // link.classList.add('active');
}

const switchContent = (contentType, event, link) => {
    var contentDiv = document.getElementById('content');

    contentDiv.innerHTML = ``;

    var url = "/quantri/" +contentType;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
            contentDiv.innerHTML = xhr.responseText;
            setActiveLink(link);
        }
    };
    xhr.open("GET", url, true);
    xhr.send();

    if (event) {
        event.preventDefault();
    }

    return false;
}

const goToAdminHome = () => {
    window.location.href = "/quantri";
}

const showProductDetail = () => {
    window.location.href = '/quantri/sanpham/'
}

const showOrderDetail = () => {
    window.location.href = '/quantri/donhang/'
}

const directThem = () => {
    window.location.href = "/quantri/sanpham/them"
}

const directChinhSua = () => {
    window.location.href = "/quantri/sanpham/sua"
}

const closeOrderDetailModal = () => {
    document.getElementById('orderDetailModal').style.display = 'none';
    document.getElementById("ID").value = "";
}

const openUpdateStatusModal = (event) => {
    document.getElementById('updateStatusModal').style.display = 'block';
    var clickedButton = event.currentTarget
    console.log(clickedButton.id);
    document.getElementById("ID").value = clickedButton.id;
    console.log(document.getElementById("ID").value);
    console.log(window.href.location)
}

const closeUpdateStatusModal = () => {
    document.getElementById('updateStatusModal').style.display = 'none';
}

const saveOrderStatus = () => {
    alert('Order status updated successfully!');
    window.location.reload()
    closeUpdateStatusModal();
}

const showAccountDetail = () => {
    window.location.href = '/quantri/taikhoan/'
}

const openEditAccountModal = () => {
    window.location.href = '/quantri/sanpham/sua'
}

const btnDeleteProduct = () => {
    var confirmDelete = confirm('Bạn có chắc chắn muốn xóa không?');

    if (confirmDelete) {
        window.history.go(-1);
        alert('Sản phẩm đã được xóa.');
    }
}

const btnDeleteAccount = () => {

    var confirmDelete = confirm('Bạn có chắc chắn muốn xóa tài khoản này không?');

    if (confirmDelete) {
        window.location.href = 'admin.html'
        alert('Tài khoản đã được xóa.');
    }
}