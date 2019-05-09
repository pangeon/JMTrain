var min=5;
var sec=60;
function timeMin() {
    if(min===0) {
        document.getElementById().innerHTML='end';
    } else {
        min--;
        document.getElementById('min').innerHTML=(min < 5) ? (0 + min) : min;
        setTimeout("timeMin();", 60000);
    }
}
function timeSec() {
    if(sec > 54000) {
        document.getElementById().innerHTML='end';
    } else {
        sec--;
        document.getElementById('sec').innerHTML=(sec < 54000) ? (0 + sec) : sec;
        setTimeout("timeSec();", 1000);
        if (sec === 0) {
            sec = 60;
        }
        if (sec < 10) {
            document.getElementById('sec').innerHTML=(sec < 54000) ? ("0" + sec) : sec;
        }
    }
}