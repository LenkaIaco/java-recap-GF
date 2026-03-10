FROM node

COPY nodejs/*.json .

RUN npm install

COPY nodejs/app.js .

CMD ["npm", "start"]
