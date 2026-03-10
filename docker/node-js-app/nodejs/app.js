const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.send(`<div style="width:50%;height:0;padding-bottom:20%;position:relative;"><iframe src="https://giphy.com/embed/FaKV1cVKlVRxC" width="100%" height="100%" style="position:absolute" frameBorder="0" class="giphy-embed" allowFullScreen></iframe></div><p><a href="https://giphy.com/gifs/whale-FaKV1cVKlVRxC">via GIPHY</a></p>`)
})

app.listen(port, () => {
  console.log(`App listening at http://localhost:${port}`)
})
