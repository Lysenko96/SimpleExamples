<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        let chatUnit = {
            init(){
                this.startbox = document.querySelector(".start");
                this.chatbox = document.querySelector(".chat");

                this.startBtn = this.startbox.querySelector("button");
                this.nameInput = this.startbox.querySelector("input");

                this.msgTextArea = this.chatbox.querySelector("textarea");
                this.chatMessageContainer = this.chatbox.querySelector(".messages");

                this.handlerEvent();
            },

            handlerEvent(){
                this.startBtn.addEventListener("click", e => this.openSocket())
                this.msgTextArea.addEventListener("keyup", e=>{
                    //if(e.ctrlKey && e.keyCode === 13) {
                    if(e.keyCode === 13) {
                        e.preventDefault();
                        this.send();
                    }
                })
            },

            send(){
                this.sendMessage({
                    author:this.author,
                    text:this.msgTextArea.value
                })
            },

            openSocket(){
                this.author = this.nameInput.value;
                this.ws = new WebSocket("ws://192.168.0.237:8080/chat/" + this.author);
                this.ws.onopen = () => this.onOpenSock();
                this.ws.onmessage = (e) => this.onMessage(JSON.parse(e.data));

                this.ws.onclose = () => this.onClose();
                this.startbox.style.display="none";
                this.chatbox.style.display="block";
            },

            onOpenSock(){

            },

            onMessage(msg){
                let msgBlock = document.createElement("div");
                msgBlock.className = "msg";
                let fromBlock = document.createElement("div");
                fromBlock.className = "from";
                fromBlock.innerText=msg.author;
                let textBlock = document.createElement("div");
                textBlock.className = "text";
                textBlock.innerText=msg.text;

                msgBlock.appendChild(fromBlock);
                msgBlock.appendChild(textBlock);

                this.chatMessageContainer.appendChild(msgBlock);

            /*    let msghtml =
                    '<div class="msg">' +
                    '<div class="from">user</div>' +
                    '<div class="text">hello world</div>' +
                    '</div>';*/
            },

            onClose(){

            },

            sendMessage(msg){
                this.onMessage({author:"I,m", text:msg.text});
                this.msgTextArea.value = "";
                this.ws.send(JSON.stringify(msg));
            }
        };

        window.addEventListener("load", e => chatUnit.init());

    </script>
</head>
<body>
<h1>Chat</h1>
<div class="start">
    <input type="text" class="username" placeholder="enter name">
    <button id="start">start</button>
</div>
<div class="chat">
    <div class="messages">

    </div>
    <textarea class="msg">

    </textarea>
</div>
</body>
</html>
