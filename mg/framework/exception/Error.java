package mg.framework.exception;

public class Error {
    public static String getError(String message) {
        String error = "<!DOCTYPE html>"+
                        "<html lang='en'>"+
                        "<head>"+
                        "    <meta charset='UTF-8'>"+
                        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>"+
                        "    <title>Error page</title>"+
                        "    <style>"+
                        "        body {"+
                        "            margin: 0;"+
                        "            padding: 0;"+
                        "            min-height: 100vh;"+
                        "            display: flex;"+
                        "            justify-content: center;"+
                        "            align-items: center;"+
                        "            background: linear-gradient(45deg, #1a1a1a, #2d2d2d);"+
                        "            font-family: Arial, sans-serif;"+
                        "            color: #fff;"+
                        "            overflow: hidden;"+
                        "        }"+
                        "        .container {"+
                        "            position: relative;"+
                        "            text-align: center;"+
                        "        }"+
                        "        .error-number {"+
                        "            font-size: 120px;"+
                        "            font-weight: 200;"+
                        "            margin: 0;"+
                        "            color: rgba(255, 255, 255, 0.8);"+
                        "            text-shadow: 0 0 20px rgba(255, 255, 255, 0.3);"+
                        "        }"+
                        "        .error-text {"+
                        "            font-size: 24px;"+
                        "            margin-top: 0;"+
                        "            color: rgba(255, 255, 255, 0.6);"+
                        "        }"+
                        "        .figure {"+
                        "            position: relative;"+
                        "            width: 200px;"+
                        "            height: 200px;"+
                        "            margin: 40px auto;"+
                        "        }"+
                        "        .figure::before {"+
                        "            content: '';"+
                        "            position: absolute;"+
                        "            width: 100%;"+
                        "            height: 100%;"+
                        "            background: url(\"data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 100 100'%3E%3Cpath fill='rgba(255,255,255,0.8)' d='M50,20 C45,20 40,25 40,35 L40,50 L35,70 L45,60 L47,80 L53,80 L55,60 L65,70 L60,50 L60,35 C60,25 55,20 50,20 Z'/%3E%3Ccircle fill='rgba(255,255,255,0.9)' cx='50' cy='45' r='3'/%3E%3C/svg%3E\") no-repeat center;"+
                        "        }"+
                        "        .glow {"+
                        "            position: absolute;"+
                        "            width: 300px;"+
                        "            height: 300px;"+
                        "            background: radial-gradient(circle, rgba(255,255,255,0.1) 0%, rgba(255,255,255,0) 70%);"+
                        "            top: 50%;"+
                        "            left: 50%;"+
                        "            transform: translate(-50%, -50%);"+
                        "            pointer-events: none;"+
                        "        }"+
                        "        .stars {"+
                        "            position: absolute;"+
                        "            width: 100%;"+
                        "            height: 100%;"+
                        "            top: 0;"+
                        "            left: 0;"+
                        "            pointer-events: none;"+
                        "        }"+
                        "        .star {"+
                        "            position: absolute;"+
                        "            width: 2px;"+
                        "            height: 2px;"+
                        "            background: white;"+
                        "            border-radius: 50%;"+
                        "            animation: twinkle 1.5s infinite;"+
                        "        }"+
                        "        @keyframes twinkle {"+
                        "            0%, 100% { opacity: 0.3; }"+
                        "            50% { opacity: 1; }"+
                        "        }"+
                        "    </style>"+
                        "</head>"+
                        "<body>"+
                        "    <div class='container'>"+
                        "        <h1 class='error-number'>Error</h1>"+
                        "        <p class='error-text'>"+ message +"</p>"+
                        "        <div class='figure'>"+
                        "            <div class='glow'></div>"+
                        "        </div>"+
                        "        <div class='stars'>"+
                        "            <div class='star' style='top: 20%; left: 15%;'></div>"+
                        "            <div class='star' style='top: 30%; left: 35%;'></div>"+
                        "            <div class='star' style='top: 25%; left: 55%;'></div>"+
                        "            <div class='star' style='top: 15%; left: 75%;'></div>"+
                        "            <div class='star' style='top: 35%; left: 85%;'></div>"+
                        "        </div>"+
                        "    </div>"+
                        "    <script>"+
                        "        document.querySelectorAll('.star').forEach(star => {"+
                        "            star.style.animationDelay = Math.random() * 1.5 + 's';"+
                        "        });"+
                        "    </script>"+
                        "</body>"+
                        "</html>";
        return error;
    }
}
