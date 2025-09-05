let ws;

function connect() {
    const username = document.getElementById("userName").value;
    if ("WebSocket" in window) {
        ws = new WebSocket("ws://localhost:8080/WebSocketDemo/chatEndpoint/" + username);
        ws.onopen = function () {
        };
        ws.onmessage = function (evt) {
            const json = JSON.parse((evt.data));
            const currentValue = document.getElementById('output').innerHTML;
            document.getElementById("output").innerHTML = currentValue
                + '<br/>' + json.userName + ": " + json.message;

        };
        ws.onclose = function () {
            alert("Connection is closed...");
        };
    } else {
        alert("WebSocket NOT supported by your Browser!");
    }
}

function sendMessage() {
    const username = document.getElementById('userName').value;
    const message = document.getElementById('message').value;
    const json = {
        // userName có vẻ không cần thiết vì đã lưu userName khi connect và bên server(ChatServerEndpoint.java)
        // và khi gửi qua thì có lấy tên từ Session rồi
        'userName': username,
        'message': message
    };
    ws.send(JSON.stringify(json));
    return false;
}