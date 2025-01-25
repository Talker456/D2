const createButton = document.getElementById('create-btn');

if (createButton != null) {
    createButton.addEventListener('click', event => {
        fetch('/api/sample', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                text: document.getElementById('text').value,
            })
        })
            .then((response) => {
                alert('등록 완료되었습니다.');
                location.replace('/samples');
            });
    });
}