cart.js

document.addEventListener("DOMContentLoaded", function () {
  const updateBtn = document.getElementById("updateCartBtn");
  const cartTable = document.querySelector(".cart-table");
  const removeColumns = document.querySelectorAll('.remove-col');
  const qtyInputs = document.querySelectorAll('.quantity-amount');

  function updateTotal() {
    let subtotal = 0;
    document.querySelectorAll('tbody tr').forEach((row) => {
      const priceCell = row.querySelector('.price');
      const qtyInput = row.querySelector('.quantity-amount');
      const itemTotalCell = row.querySelector('.item-total');

      if (priceCell && qtyInput && itemTotalCell) {
        const price = parseFloat(priceCell.innerText.replace('$', '')) || 0;
        const qty = parseInt(qtyInput.value) || 0;
        const itemTotal = price * qty;

        itemTotalCell.innerText = "$" + itemTotal.toFixed(2);
        subtotal += itemTotal;
      }
    });

    const subtotalDisplay = document.getElementById('cart-subtotal');
    if (subtotalDisplay) {
      subtotalDisplay.innerText = "$" + subtotal.toFixed(2);
    }
  }

  if (updateBtn && cartTable) {
    updateBtn.addEventListener("click", function () {
      cartTable.classList.toggle("cart-show-remove");
      if (cartTable.classList.contains("cart-show-remove")) {
        updateBtn.textContent = "Cancel Update";
      } else {
        updateBtn.textContent = "Update Cart";
      }
    });
  }

  document.querySelectorAll('.increase').forEach((btn, idx) => {
    btn.addEventListener('click', () => {
      const input = qtyInputs[idx];
      input.value = parseInt(input.value) + 1;
      updateTotal();
    });
  });

  document.querySelectorAll('.decrease').forEach((btn, idx) => {
    btn.addEventListener('click', () => {
      const input = qtyInputs[idx];
      if (parseInt(input.value) > 1) {
        input.value = parseInt(input.value) - 1;
        updateTotal();
      }
    });
  });

  updateTotal();
});