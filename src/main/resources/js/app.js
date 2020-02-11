require('bootstrap');

const jQuery = require('jquery');

jQuery('#clickedNext').click((event) => {
    event.preventDefault();

    const url = jQuery('#linkField').val();

    const result = jQuery('#result');
    const error = jQuery('#error');
    const shortURL = jQuery('#shortURL');
    const errorMessage = jQuery('#errorMessage');

    // Hide blocks
    result.attr('style', 'display: none');
    error.attr('style', 'display: none');

    // Send a request to our backend
    jQuery.ajax({
        url: '/api/v1/short',
        method: 'POST',
        data: {
            url: url,
        },
        success: (response) => {
            if (response['ok']) {
                shortURL.val(response['url']);
                result.show();
            } else {
                errorMessage.text(response['message']);
                error.show();
            }
        }
    })
});
