// scripts.js

function confirmDelete(form) {
    // Better confirmation dialog; returns true to proceed
    if (confirm("Êtes-vous sûr·e de vouloir supprimer cette tâche ? Cette action est irréversible.")) {
        return true;
    }
    return false;
}

// optional: autofocus first input on create form
document.addEventListener('DOMContentLoaded', function(){
    const el = document.querySelector('form input[th\\:field], form input[name="title"], form input[id="title"]');
    if(el) el.focus();
});
