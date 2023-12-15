<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Orlovský pohárek</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>

<div class="isolate bg-white px-6 py-24 sm:py-32 lg:px-8">
    <div
            class="absolute inset-x-0 top-[-10rem] -z-10 transform-gpu overflow-hidden blur-3xl sm:top-[-20rem]"
            aria-hidden="true"
    >
        <div
                class="relative left-1/2 -z-10 aspect-[1155/678] w-[36.125rem] max-w-none -translate-x-1/2 rotate-[30deg] bg-gradient-to-tr from-[#ff80b5] to-[#9089fc] opacity-30 sm:left-[calc(50%-40rem)] sm:w-[72.1875rem]"
                style="
            clip-path: polygon(
              74.1% 44.1%,
              100% 61.6%,
              97.5% 26.9%,
              85.5% 0.1%,
              80.7% 2%,
              72.5% 32.5%,
              60.2% 62.4%,
              52.4% 68.1%,
              47.5% 58.3%,
              45.2% 34.5%,
              27.5% 76.7%,
              0.1% 64.9%,
              17.9% 100%,
              27.6% 76.8%,
              76.1% 97.7%,
              74.1% 44.1%
            );
          "
        ></div>
    </div>
    <div class="mx-auto max-w-2xl text-center">
        <h2 class="text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
            Orlovský pohárek
        </h2>
        <p class="mt-2 text-lg leading-8 text-gray-600">
            Dům dětí a mládeže Orlová, příspěvková organizace
        </p>
        <p class="text-lg leading-8 text-gray-600">
            Masarykova 958, Orlová 735 14, orlovskypoharek@gmail.com
        </p>

        <h2 class="mt-4 font-bold tracking-tight text-red-600 text-2xl">
            Každá choreografie musí mít svou přihlášku!
        </h2>
    </div>
    <form id="mainForm" action="saveApplicationForm" method="post" class="mx-auto mt-16 max-w-xl sm:mt-20">
        <div class="grid grid-cols-1 gap-x-8 gap-y-6 sm:grid-cols-2">
            <div class="sm:col-span-2">
                <label
                        for="groupName"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Název tanečního kolektivu</label
                >
                <div class="mt-2.5">
                    <input
                            type="text"
                            name="groupName"
                            id="groupName"
                            placeholder="TK JOY"
                            autocomplete="organization"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>
            <div class="sm:col-span-2">
                <label
                        for="contact"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Kontakt na odpovědnou osobu (jméno, email, telefon)</label
                >
                <div class="mt-2.5">
                    <input
                            type="text"
                            name="contact"
                            id="contact"
                            placeholder="Kateřina Šostoková, sostokova@ddm-orlova.cz, 603 154 426"
                            autocomplete="email"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>
            <div class="sm:col-span-2">
                <label
                        for="choreografiName"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Název choreografie</label
                >
                <div class="mt-2.5">
                    <input
                            type="text"
                            name="choreografiName"
                            id="choreografiName"
                            placeholder="Klíčov"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>
            <div>
                <label
                        for="ageCategory"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Věková kategorie (např.junioři)</label
                >
                <div class="mt-2.5">
                    <input
                            type="text"
                            name="ageCategory"
                            id="ageCategory"
                            placeholder="Mini"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>
            <div>
                <label
                        for="danceCategory"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Soutěžní disciplína (např. street dance)</label
                >
                <div class="mt-2.5">
                    <input
                            type="text"
                            name="danceCategory"
                            id="danceCategory"
                            placeholder="Show dance"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>
            <div class="sm:col-span-2">
                <label
                        for="nameOfChoreografer"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Jméno choreografa</label
                >
                <div class="mt-2.5">
                    <input
                            type="text"
                            name="nameOfChoreografer"
                            id="nameOfChoreografer"
                            placeholder="Kateřina Šostoká"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>

            <div>
                <label
                        for="numOfDancer"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Počet tanečníků ve formaci</label
                >
                <div class="mt-2.5">
                    <input
                            type="number"
                            name="numOfDancer"
                            id="numOfDancer"
                            placeholder="18"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>

            <div>
                <label
                        for="lenghtOfDance"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Délka vystoupení (mm:ss)</label
                >
                <div class="mt-2.5">
                    <input
                            type="text"
                            name="lenghtOfDance"
                            id="lenghtOfDance"
                            placeholder="3:24"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>

            <div>
                <label
                        for="numOfDancerInGroup"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Počet členů celého souboru</label
                >
                <div class="mt-2.5">
                    <input
                            type="number"
                            name="numOfDancerInGroup"
                            id="numOfDancerInGroup"
                            placeholder="68"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>

            <div class="sm:col-span-2">
                <label
                        for="meansOfTransport"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Dopravní prostředek (vlastní autobus, auto, vlak)</label
                >
                <div class="mt-2.5">
                    <input
                            type="text"
                            name="meansOfTransport"
                            id="meansOfTransport"
                            placeholder="Vlastní autobus"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>

            <div class="sm:col-span-2">
                <label
                        for="message"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Máte nějaký dotaz navíc ?
                </label>
                <div class="mt-2.5">
              <textarea
                      name="message"
                      id="message"
                      rows="4"
                      class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              ></textarea>
                </div>
            </div>
            <div class="flex gap-x-4 sm:col-span-2">
                <div class="flex h-6 items-center">
                    <!-- Enabled: "bg-indigo-600", Not Enabled: "bg-gray-200" -->
                    <button
                            id="policiesButton"
                            type="button"
                            class="bg-gray-200 flex w-8 flex-none cursor-pointer rounded-full p-px ring-1 ring-inset ring-gray-900/5 transition-colors duration-200 ease-in-out focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
                            role="switch"
                            aria-checked="false"
                            aria-labelledby="switch-1-label"
                    >
                        <span class="sr-only">Agree to policies</span>
                        <!-- Enabled: "translate-x-3.5", Not Enabled: "translate-x-0" -->
                        <span
                                id="policiesSpan"
                                aria-hidden="false"
                                class="translate-x-0 h-4 w-4 transform rounded-full bg-white shadow-sm ring-1 ring-gray-900/5 transition duration-200 ease-in-out"
                        ></span>
                    </button>
                </div>
                <label class="text-sm leading-6 text-gray-600" id="switch-1-label">
                    Souhlasím se zpracováním osobních údajů
                    <a href="#" class="font-semibold text-indigo-600"
                    >osobních údajů</a
                    >.
                </label>
            </div>
        </div>
        <div class="mt-10">
            <button
                    id="newMember"
                    aria-checked="false"
                    type="button"
                    class="block rounded-md bg-indigo-500 px-3.5 py-2 text-center text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
            >
                Přidat tanečníka
            </button>
        </div>
        <div class="mt-5 divide-y">
            <p class="text-lg leading-8 text-gray-900">Seznam tanečníků</p>

            <ul id="members" role="list"></ul>
        </div>
        <div class="mt-10">
            <button
                    id="submitForm"
                    type="submit"
                    class="block w-full rounded-md bg-indigo-600 px-3.5 py-2.5 text-center text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
            >
                Závazně odeslat
            </button>
        </div>
    </form>

    <form id="newMemberForm" class="mx-auto mt-16 max-w-xl sm:mt-20 hidden">
        <div class="grid grid-cols-1 gap-x-8 gap-y-6 sm:grid-cols-2">
            <div>
                <label
                        for="nameOfDancer"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Jméno</label
                >
                <div class="mt-2.5">
                    <input
                            type="text"
                            name="nameOfDancer"
                            id="nameOfDancer"
                            placeholder="Roman"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>
            <div>
                <label
                        for="lastNameOfDancer"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Příjmení</label
                >
                <div class="mt-2.5">
                    <input
                            type="text"
                            name="lastNameOfDancer"
                            id="lastNameOfDancer"
                            placeholder="Šostok"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>
            <div>
                <label
                        for="dateOfBirth"
                        class="block text-sm font-semibold leading-6 text-gray-900"
                >Datum narození</label
                >
                <div class="mt-2.5">
                    <input
                            type="date"
                            name="dateOfBirth"
                            id="dateOfBirth"
                            class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                            required
                    />
                </div>
            </div>
            <div class="mt-10">
                <button
                        id="addMember"
                        aria-checked="false"
                        type="button"
                        class="block w-full rounded-md bg-indigo-600 px-3.5 py-2.5 text-center text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
                >
                    Přidat
                </button>
            </div>
        </div>
    </form>
</div>
<script type="module" src="js/newMember.js"></script>
<script type="module" src="js/agreeToPolicy.js"></script>
<script type="module" src="js/validateForm.js"></script>
</body>
</html>