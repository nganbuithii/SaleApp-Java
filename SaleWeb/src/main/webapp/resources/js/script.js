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


function drawChartRevenue(ctx, label, data, title) {
    // const ctx = document.getElementById('myChart');

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: label,
            datasets: [{
                label: title,
                data: data,
                borderWidth: 1,
                backgroundColor:['pink','yello','green','white','orange']
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}