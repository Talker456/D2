const createButton = document.getElementById('create-btn');

createButton.addEventListener('click',event => {
    const title = document.getElementById('title').value;
    const day = document.querySelector('input[type=radio]:checked').value;
    const time = document.getElementById('start').value;
    const category = document.getElementById('category').value;
    const duration = document.getElementById('duration').value;

    console.log(title);
    console.log(day);
    console.log(time);
    console.log(category);
    console.log(duration);

    const start = formatDateTime(day,time);
    console.log(start);

    const end = addMinutesToDateTime(start, duration);
    console.log(end);

    fetch('/api/plan', {
                method: 'POST',
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    title: document.getElementById('title').value,
                    start: start,
                    end: end,
                    category: document.getElementById('category').value,
                })
            })
            .then((response) => {
                location.replace('/planner2');
            });

});

function formatDateTime(dateTime, timeInput) {
    // Extract the date part from the dateTime input
    const datePart = dateTime.split('T')[0];

    // Combine the date with the cleaned time
    const formattedDateTime = `${datePart}T${timeInput}`;

    return formattedDateTime;
}

function addMinutesToDateTime(dateTime, minutes) {
    // Parse the datetime string into a JavaScript Date object
    const date = new Date(dateTime);

    // Add the specified number of minutes
    date.setMinutes(date.getMinutes() + parseInt(minutes));

    // Format the result back to the ISO 8601 format (YYYY-MM-DDTHH:MM)
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0'); // Month is zero-indexed
    const day = String(date.getDate()).padStart(2, '0');
    const hours = String(date.getHours()).padStart(2, '0');
    const minutesFormatted = String(date.getMinutes()).padStart(2, '0');

    return `${year}-${month}-${day}T${hours}:${minutesFormatted}`;
}
