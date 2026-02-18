const formatIndonesia = Intl.NumberFormat(["id-ID", "en-US"], { // pakai array untuk fallback
    minimumFractionDigits: 0,
    maximumFractionDigits: 2
});

console.log(formatIndonesia.format(1_000.2));
console.log(formatIndonesia.format(13));
console.log(formatIndonesia.format(13n));

const formatRP = Intl.NumberFormat("id-ID", {
    style: "currency", // <- default "decimal"
    currency: "IDR",
    minimumFractionDigits: 0
});

console.log(formatRP.format(12_000));

const trailingZero = Intl.NumberFormat("id-ID", {
    minimumIntegerDigits: 6
});
console.log(trailingZero.format(20_000));


console.log(Intl.NumberFormat(undefined, {numberingSystem: "arab"}).format("12345"));
console.log(Intl.supportedValuesOf("currency").slice(0, 10));
console.log(Intl.supportedValuesOf("unit"));
console.log(Intl.supportedValuesOf("numberingSystem").slice(0, 10));