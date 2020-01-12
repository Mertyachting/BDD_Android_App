const http = require('http');
const express = require('express');

const hostname = '127.0.0.1';
const port = 3000;
const app = express();

app.get('/1', (req,res) => {
    res.send('You must do the things you think you cannot do.')
});

app.get('/2', (req,res) => {
    res.send('You have to be better than you ever thought you could be.')
});

app.get('/0', (req,res) => {
    res.end('Good, better, best. Never let it rest. \'Til your good is better and your better is best.\n');
});

app.get('/3', (req,res) => {
    res.end('Setting goals is the first step in turning the invisible into the visible.\n');
});

app.get('/4', (req,res) => {
    res.end('Begin to be now what you will be hereafter.\n');
});

app.get('/5', (req,res) => {
    res.end('Don\'t think, just do.\n');
});

app.get('/6', (req,res) => {
    res.end('Don\'t watch the clock; do what it does. Keep going.\n');
});

app.get('/7', (req,res) => {
    res.end('How do you know you\'re going to do something, until you do it?\n');
});


app.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});