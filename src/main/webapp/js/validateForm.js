import { ApplicationForm } from "./ApplicationForm.js";

var validForm = true;
var form = document.getElementById("mainForm");

form.addEventListener("submit", function (event) {
  event.preventDefault();
  validateForm();

});

function validateForm() {
  var numOfDancer = document.getElementById("numOfDancer").value;
  var policiesButton = document.getElementById("policiesButton");
  var ageCategory = document.getElementById("ageCategory").value;

  var applicationForm = createApplicationForm(numOfDancer, ageCategory);

  switch (true) {
    case !validatePolicies(policiesButton):
      validForm = false;
      break;
    case !validateNumOfDancers(numOfDancer):
      validForm = false;
      break;
    case !validateAgeCategory(ageCategory):
      validForm = false;
      break;
    default:
      confirmForm(applicationForm);
  }
}

function validateNumOfDancers(numOfDancer) {
  var validNumOfDancers = document.querySelector(".id-" + (numOfDancer - 1));

  if (!validNumOfDancers) {
    alert("Počet tanečníků musí odpovídat seznamu tanečníků");
  }
  return validNumOfDancers;
}

function validatePolicies(policiesButton) {
  var activePolicies = policiesButton.getAttribute("aria-checked") === "true";

  if (!activePolicies) {
    alert("Musíte souhlasit se zpracováním osobních údajů");
  }
  return activePolicies;
}

function validateAgeCategory(ageCategory) {
  var storedMemberList = JSON.parse(localStorage.getItem("members"));
  var totalYears = 0;

  storedMemberList.forEach((member) => {
    var year = new Date(member.dateOfBirth).getFullYear();
    totalYears += year;
  });

  var averageYear = Math.round(totalYears / storedMemberList.length);
  console.log(averageYear);
  return true;
}

function createApplicationForm(numOfDancer, ageCategory) {
  var groupName = document.getElementById("groupName").value;
  var contact = document.getElementById("contact").value;
  var choreografiName = document.getElementById("choreografiName").value;
  var danceCategory = document.getElementById("danceCategory").value;
  var nameOfChoreografer = document.getElementById("nameOfChoreografer").value;
  var lenghtOfDance = document.getElementById("lenghtOfDance").value;
  var numOfDancerInGroup = document.getElementById("numOfDancerInGroup").value;
  var meansOfTransport = document.getElementById("meansOfTransport").value;
  var message = document.getElementById("message").value;

  return new ApplicationForm(
    groupName,
    contact,
    choreografiName,
    ageCategory,
    danceCategory,
    nameOfChoreografer,
    numOfDancer,
    lenghtOfDance,
    numOfDancerInGroup,
    meansOfTransport,
    message,
    JSON.parse(localStorage.getItem("members"))
  );
}

function confirmForm(applicationForm) {
  var isConfirmed = window.confirm("Opravdu chcete odeslat formulář?");

  if (isConfirmed) {
    localStorage.setItem("ApplicationForm", applicationForm);
    localStorage.removeItem("members");
    form.submit();
  }
}
