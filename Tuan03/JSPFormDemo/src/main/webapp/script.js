const day = {
    1: [31],
    2: [28, 29],
    3: [31],
    4: [30],
    5: [31],
    6: [30],
    7: [31],
    8: [30],
    9: [31],
    10: [30],
    11: [31],
    12: [30]
}

function dayProcess() {
    let month = document.getElementsByName("month")[0].value
    let year = document.getElementsByName("year")[0].value
    document.getElementsByName("day")[0].innerHTML = "<option>Day</option>"
    for (let i = 1; i <= (month != 2? day[month][0] : day[month][isLeapYear(year)]); i++) {
        document.getElementsByName("day")[0].innerHTML += `<option value="${i}">${i}</option>`
    }
}

function isLeapYear(year) {
    return (year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0))? 1 : 0
}