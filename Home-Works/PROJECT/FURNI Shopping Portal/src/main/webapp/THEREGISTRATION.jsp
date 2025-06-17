<style>
.registration-container {
  background: white;
  padding: 30px;
  border-radius: 20px;
  width: 500px;
  box-shadow: 15px 15px 15px rgba(0, 0, 0, 0.1);
  margin: 50px auto;
}

.registration-container h2 {
  text-align: center;
  margin-bottom: 20px;
}

.tab-buttons {
  display: flex;
  justify-content: space-between;
  margin-bottom: 15px;
}

.tab-btn {
  flex: 1;
  padding: 10px;
  border: none;
  background: #ddd;
  cursor: pointer;
  transition: 0.3s;
}

.tab-btn.active {
  background: #3B7A57;
  color: white;
}

.tab-content {
  display: none;
}

.tab-content.active {
  display: block;
}

form {
  display: flex;
  flex-direction: column;
}

form input {
  padding: 10px;
  margin: 8px 0;
  border: 1px solid #ccc;
  border-radius: 5px;
}

form button {
  background: #3B7A57;
  color: white;
  padding: 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
</style>

<div class="registration-container">
  <h2>Register</h2>
  <div class="tab-buttons">
    <button class="tab-btn active" onclick="showTab('custReg')">Customer</button>
    <button class="tab-btn" onclick="showTab('adminReg')">Admin</button>
  </div>

  <div id="custReg" class="tab-content active">
    <form action="CustomerRegisterServlet" method="post">
      <label>Full Name:</label>
      <input type="text" name="fullname" placeholder="Full Name" required />
      <label>Username:</label>
      <input type="text" name="username" placeholder="Username" required />
      <label>Password:</label>
      <input type="password" name="password" placeholder="Password" required />
      <label>Email:</label>
      <input type="email" name="email" placeholder="Email" required />
      <label>Phone:</label>
      <input type="text" name="phone" placeholder="Phone Number" required />
      <button type="submit">Register as Customer</button>
    </form>
  </div>

  <div id="adminReg" class="tab-content">
    <form action="AdminRegisterServlet" method="post">
      <label>Full Name:</label>
      <input type="text" name="fullname" placeholder="Full Name" required />
      <label>Username:</label>
      <input type="text" name="username" placeholder="Username" required />
      <label>Password:</label>
      <input type="password" name="password" placeholder="Password" required />
      <label>Email:</label>
      <input type="email" name="email" placeholder="Email" required />
      <label>Phone:</label>
      <input type="text" name="phone" placeholder="Phone Number" required />
      <button type="submit">Register as Admin</button>
    </form>
  </div>
</div>

<script>
function showTab(tabId) {
  const tabs = document.querySelectorAll(".tab-content");
  const buttons = document.querySelectorAll(".tab-btn");

  tabs.forEach(tab => tab.classList.remove("active"));
  buttons.forEach(btn => btn.classList.remove("active"));

  document.getElementById(tabId).classList.add("active");
  event.target.classList.add("active");
}
</script>
