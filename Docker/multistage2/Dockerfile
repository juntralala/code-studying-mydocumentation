FROM alpine AS builder
# RUN apk install muscl
RUN mkdir /app
WORKDIR /app
COPY hello.cpp .
RUN muscl-g++ hello.cpp

FROM alpine
COPY --form=builder hello .
CMD hello