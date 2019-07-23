var socket = new SockJS("http://localhost:8090/websocket");
var stompClient = Stomp.over(socket);
stompClient.connect({}, function(value) {
    stompClient.subscribe('/topic/greetings', function (message) {
        console.log(message.body);
    });
})

function sendMessage(value) {
    var mensagem = document.querySelector("#mensagem");
    stompClient.send("/app/message", {}, mensagem.value);
}

