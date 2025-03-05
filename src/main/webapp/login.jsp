<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Light grey background */
        }
        .form-container {
            max-width: 500px; /* Increased form width */
            background: #edf4ff; /* Light blue background */
            border-radius: 8px;
            padding: 30px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .form-container h3 {
            margin: 0;
            font-weight: 600;
            font-size: 1.6rem; /* Adjusted font size */
        }
        .form-container .text-primary {
            font-size: 1.6rem; /* Smaller font size for DASHMIN */
            color: #007bff; /* Matches blue color */
        }
        .form-container span {
            font-size: 1.4rem;
            font-weight: 500;
        }
        label {
            font-size: 0.9rem;
        }
        .form-check-label {
            font-size: 0.85rem;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            font-size: 0.95rem; /* Button font size */
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
        /* Specific selectors for Forgot Password and Sign Up */
        a.text-primary {
            font-size: 16px !important;
            color: #007bff;
            text-decoration: none;
        }
        a.text-primary:hover {
            text-decoration: none;
            color: #0056b3
        }
        .showError{
            color: red;
            text-align: center; 
        }
        .txtAdmin{
            font-size: 16px;
        }
        #success-message {
            transition: opacity 0.5s ease-in-out;
        }

    </style>
</head>
<body>
    <div class="d-flex justify-content-center align-items-center vh-100">
        <div class="form-container">
            
           	<p style="color: red;">
		        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
		    </p>
            <div class="text-center mb-4">
                <h3><span class="text-dark">Sign In</span></h3>
            </div>
            <form action="LoginController" method="POST">
                <div class="form-floating mb-3">
                    <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
                    <label for="email">Email address</label>
                </div>
                <div class="form-floating mb-4">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                    <label for="password">Password</label>
                </div>
                <button type="submit" class="btn btn-primary w-100 py-2">Sign In</button>
            </form>
           </div>
    </div>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            const successMessage = document.getElementById('success-message');
            if (successMessage) {
                setTimeout(() => {
                    successMessage.style.opacity = '0';
                }, 2000); // Hide after 3 seconds
                setTimeout(() => {
                    successMessage.remove();
                }, 3000); // Remove after 4 seconds
            }
        });
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
