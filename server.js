require('dotenv').config()  // ✅ Charger les variables d'environnement
const app = require('./app')

const start = async() => {
  try {
    const port = process.env.APP_PORT || 3000
    const host = process.env.APP_HOST || '0.0.0.0'
    
    await app.listen({ port, host })
    console.log(`✅ Server running on http://${host}:${port}`)
    console.log(`📊 Environment: ${process.env.NODE_ENV}`)
    console.log(`🗄️  Database: ${process.env.DB_HOST}:${process.env.DB_PORT}`)
  } catch (err) {
    app.log.error(err)
    process.exit(1)
  }
}

start()