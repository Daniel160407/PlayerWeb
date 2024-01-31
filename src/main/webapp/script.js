async function startup() {
    const response = await fetch("/musicPlayer/music", {method: "GET"});
    const data = await response.json();

    const playlistDiv = document.getElementById("playlist");

    for (let i = 0; i < data.length; i++) {
        playlistDiv.innerHTML += musicIcon(data, i);
    }
}

function musicIcon(data, i) {
    const icon = '<div>' +
        '<img src="https://png.pngtree.com/element_our/20190601/ourmid/pngtree-music-icon-image_1344442.jpg">'
        + <h1>${data[i]}</h1>
        + '</div>'

    return icon;
}