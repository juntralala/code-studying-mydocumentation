const birth = new Date(2024, 2, 23, 10, 32, 0, 0);

const dateFormat = Intl.DateTimeFormat("id-ID", {
    year: "numeric",
    month: "numeric",
    day: "2-digit",
    weekday: "long",
    hour: "numeric",
    minute: "numeric",
    second: "numeric",
    fractionalSecondDigits: 2,
    hour12: true,
    timeZone: "Asia/Makassar",
    timeZoneName: "short"
});

console.log(dateFormat.format(birth));
console.log(new Intl.DateTimeFormat("id", {numberingSystem: "arab"}).format(birth));

// alternatif, bisa langsung pakai method toLocaleDateString();
// console.log(birth.toLocaleTimeString("id", {}));
console.error(birth.toLocaleString("id", {day: "2-digit", month: "long", year: "numeric"}));
console.log(birth.toLocaleString("id", {dateStyle: "short", timeStyle: "short", hour12: true}));
console.log(birth.toLocaleString("id", {dateStyle: "medium"}));
console.log(birth.toLocaleString("id", {dateStyle: "long"}));
console.log(birth.toLocaleString("id", {dateStyle: "full", timeStyle: "full"}));

// ISO Date format
console.log(birth.toISOString());