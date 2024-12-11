package mg.framework.exception;

public class Error {
    public static String getError(String message) {
        String error = "<!DOCTYPE html>\r\n" + //
                        "<html lang='en'>\r\n" + //
                        "<head>\r\n" + //
                        "    <meta charset='UTF-8'>\r\n" + //
                        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\r\n" + //
                        "    <title>Error page</title>\r\n" + //
                        "    <style>\r\n" + //
                        "        body {\r\n" + //
                        "            display: flex;\r\n" + //
                        "            justify-content: center;\r\n" + //
                        "            align-items: center;\r\n" + //
                        "            height: 100vh;\r\n" + //
                        "            margin: 0;\r\n" + //
                        "            background-color: #1b2d1b; /* Dark green background */\r\n" + //
                        "            font-family: 'Helvetica Neue', Arial, sans-serif; /* Change font for a modern look */\r\n" + //
                        "            color: #e0f7e0; /* Light text color */\r\n" + //
                        "            text-align: center; /* Center text in body */\r\n" + //
                        "        }\r\n" + //
                        "        .error {\r\n" + //
                        "            padding: 30px 40px; /* Increased padding for more space */\r\n" + //
                        "            border: 2px solid #a5d6a7; /* Slightly thicker border */\r\n" + //
                        "            border-radius: 8px; /* More rounded corners */\r\n" + //
                        "            background-color: #2e4c2e; /* Medium green card background */\r\n" + //
                        "            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.7); /* Stronger shadow for depth */\r\n" + //
                        "        }\r\n" + //
                        "        h1 {\r\n" + //
                        "            font-size: 60px; /* Larger font size for the error code */\r\n" + //
                        "            margin: 0 0 10px; /* Margin at the bottom for spacing */\r\n" + //
                        "        }\r\n" + //
                        "        p {\r\n" + //
                        "            font-size: 24px; /* Slightly larger font size for the paragraph */\r\n" + //
                        "            margin: 0; /* No margin for consistent spacing */\r\n" + //
                        "        }\r\n" + //
                        "    </style>\r\n" + //
                        "</head>\r\n" + //
                        "<body>\r\n" + //
                        "    <div class='error'>\r\n" + //
                        "        <h1>Error</h1>\r\n" + //
                        "        <p>"+message+"</p>\r\n" + //
                        "    </div>\r\n" + //
                        "</body>\r\n" + //
                        "</html>";
        return error;
    }
}
