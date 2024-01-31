window.onload = function () {
    startup();
};

async function startup() {
    const response = await fetch("/musicPlayer/music", {method: "GET"});
    const jsonArray = await response.json();

    const playlistDiv = document.getElementById("playlist");

    for (let i = 0; i < jsonArray.length; i++) {
        playlistDiv.innerHTML += musicIcon(jsonArray[i]);
    }
}

function musicIcon(data) {
    const icon = '<div>' +
        '<img src="https://png.pngtree.com/element_our/20190601/ourmid/pngtree-music-icon-image_1344442.jpg">'
        + `<h1>${data.name}</h1>`
        + '</div>'

    return icon;
}