<style>
.login-container {
  background: white;
  padding: 30px;
  border-radius: 20px;
  width: 350px;
  box-shadow: 15px 15px 15px rgba(0, 0, 0, 0.1);
  margin: 50px auto;
}

.login-container h2 {
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

<div class="login-container">
  <h2>Login</h2>
  <div class="tab-buttons">
    <button class="tab-btn active" onclick="showTab('customer')">Customer</button>
    <button class="tab-btn" onclick="showTab('admin')">Admin</button>
  </div>

  <div id="customer" class="tab-content active">
    <form>
      <label>Email:</label>
      <input type="email" placeholder="Customer Email" required />
      <label>Password:</label>
      <input type="password" placeholder="Password" required />
      <button type="submit">Login as Customer</button>
    </form>
  </div>

  <div id="admin" class="tab-content">
    <form>
      <label>Email:</label>
      <input type="email" placeholder="Admin Email" required />
      <label>Password:</label>
      <input type="password" placeholder="Password" required />
      <button type="submit">Login as Admin</button>
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
