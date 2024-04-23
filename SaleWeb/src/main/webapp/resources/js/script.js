function deleteProduct(id) {
    let url = '/SaleWeb/products/' + id;
    fetch(url, {
        method: "DELETE"
    }).then(res => {
        if (res.status === 204) {
            location.reload();
        } else {
            alert("Error");
        }
    }).catch(error => {
        console.error('Error:', error);
        alert("Error");
    });
}
