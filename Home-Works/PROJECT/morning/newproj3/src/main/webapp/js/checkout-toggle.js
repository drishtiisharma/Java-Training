document.addEventListener("DOMContentLoaded", function() {
    // Shipping address toggle functionality
    const checkbox = document.getElementById('c_ship_different_address');
    const addressSection = document.getElementById('ship_different_address');
    
    if (checkbox && addressSection) {
        // Initialize Bootstrap collapse
        const bsCollapse = new bootstrap.Collapse(addressSection, {
            toggle: false
        });
        
        // Set initial state
        if (!checkbox.checked) {
            bsCollapse.hide();
        }
        
        // Add change event listener
        checkbox.addEventListener('change', function() {
            if (this.checked) {
                bsCollapse.show();
            } else {
                bsCollapse.hide();
            }
        });
    }

    // Payment method toggle functionality
    const codPayment = document.getElementById('codPayment');
    const onlinePayment = document.getElementById('onlinePayment');
    const onlineDetails = document.getElementById('onlinePaymentDetails');
    
    // Toggle payment details visibility
    function togglePaymentDetails() {
        if(onlinePayment.checked) {
            onlineDetails.style.display = 'block';
            // Make card details required
            document.getElementById('cardNumber').required = true;
            document.getElementById('expiryDate').required = true;
            document.getElementById('cvv').required = true;
        } else {
            onlineDetails.style.display = 'none';
            // Make card details not required
            document.getElementById('cardNumber').required = false;
            document.getElementById('expiryDate').required = false;
            document.getElementById('cvv').required = false;
        }
    }
    
    // Initialize payment details
    if (codPayment && onlinePayment && onlineDetails) {
        togglePaymentDetails();
        
        // Add event listeners
        codPayment.addEventListener('change', togglePaymentDetails);
        onlinePayment.addEventListener('change', togglePaymentDetails);
        
        // Form validation
        document.getElementById('checkoutForm')?.addEventListener('submit', function(e) {
            if(!document.querySelector('input[name="paymentMethod"]:checked')) {
                e.preventDefault();
                alert('Please select a payment method');
                return false;
            }
            
            if(document.getElementById('onlinePayment').checked) {
                // Validate card details if online payment selected
                const cardNumber = document.getElementById('cardNumber').value;
                const expiryDate = document.getElementById('expiryDate').value;
                const cvv = document.getElementById('cvv').value;
                
                if(!cardNumber || !expiryDate || !cvv) {
                    e.preventDefault();
                    alert('Please enter all card details');
                    return false;
                }
                
                // Simple card validation (16 digits)
                if(!/^\d{16}$/.test(cardNumber.replace(/\s/g, ''))) {
                    e.preventDefault();
                    alert('Please enter a valid 16-digit card number');
                    return false;
                }
                
                // Simple expiry date validation (MM/YY)
                if(!/^\d{2}\/\d{2}$/.test(expiryDate)) {
                    e.preventDefault();
                    alert('Please enter expiry date in MM/YY format');
                    return false;
                }
                
                // Simple CVV validation (3 or 4 digits)
                if(!/^\d{3,4}$/.test(cvv)) {
                    e.preventDefault();
                    alert('Please enter a valid CVV (3 or 4 digits)');
                    return false;
                }
            }
        });
    }
});