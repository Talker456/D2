const createButton = document.getElementById('create-btn');

if (createButton != null) {
    createButton.addEventListener('click', event => {
        fetch('/api/plan', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                start: document.getElementById('start').value,
                end: document.getElementById('end').value,
                category: document.getElementById('category').value,
            })
        })
            .then((response) => {
                location.replace('/plans');
            });
    });
}

function update(object){
    let id = object.value;
    let title = 'title'+id;
    let start = 'start'+id;
    let end = 'end'+id;
    let category = 'category'+id;

        fetch('/api/plan/' + id, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById(title).value,
                start: document.getElementById(start).value,
                end: document.getElementById(end).value,
                category: document.getElementById(category).value,
            })
        })
            .then((response) => {
                location.replace('/plans');
            });
}

function delete_plan(object){
    let id = object.value;
    console.log(id);
    fetch('/api/plan/' + id, {
            method: 'DELETE',
    })
           .then((response) => {
               location.replace('/plans');
           });
}

