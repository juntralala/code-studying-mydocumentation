const log = console.log;

const callback = () => log("Regular timeout callback has run");

const urgentCallback = () => log("*** Oh noes! An urgent callback has run!");

const doWork = () => {
  let result = 1;

  queueMicrotask(urgentCallback);
  queueMicrotask(()=> log(1));
  queueMicrotask(()=> log(2));
  queueMicrotask(()=> log(3));
  queueMicrotask(()=> log(4));

  for (let i = 2; i <= 10; i++) {
    result *= i;
  }
  return result;
};

log("Main program started");
setTimeout(callback, 0);
log(`10! equals ${doWork()}`);
log("Main program exiting");